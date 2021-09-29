<?php
namespace mvc\Core;

use mvc\Config\Database;
use mvc\Core\ResourceModelInterface;
use PDO;

class ResourceModel implements ResourceModelInterface
{
   private $table;
   private $id;
   private $model;

   function _init($table, $id, $model)
   {
        $this->table = $table;
        $this->id = $id;
        $this->model = $model;

   }

   function save($model)
   {

      $properties = $model->getProperties();
      
       if($model->getId() === null){
          unset($properties['id']);  
       }

      $stringModel = 'title = :title, description = :description';
     if ($model->getId() !== null) {
      $sql = "UPDATE {$this->table} SET $stringModel, updated_at = :updated_at WHERE ".$this->id.' = :id';
      $req = Database::getBdd()->prepare($sql);
      $date = array("id" => $model->getId(), 'updated_at' => date('Y-m-d H:i:s'));

      return $req->execute(array_merge($properties, $date));
     
  } else  if ($model->getId() === null) {
      $sql = "INSERT INTO {$this->table} SET $stringModel, created_at = :created_at, updated_at = :updated_at";
      $req = Database::getBdd()->prepare($sql);
      $date = array("created_at" => date('Y-m-d H:i:s'), 'updated_at' => date('Y-m-d H:i:s'));

      return $req->execute(array_merge($properties, $date));        
  } 
   }

   //tim id
   function get($id) 
   {
      $sql = "SELECT * FROM {$this->table} WHERE id = :id";
      $req = Database::getBdd()->prepare($sql);
      $req->execute([':id' => $id]);
      
      return $req->fetchAll(PDO::FETCH_OBJ);
   }

   // tim tat ca ban ghi
   function getAll()
   {
      $sql = "SELECT * FROM {$this->table}";
      $req = Database::getBdd()->prepare($sql);
      $req->execute();

      return $req->fetchAll(PDO::FETCH_OBJ);
   }

   // xoa theo id
   function delete($model)
   {   
      $sql =  "DELETE FROM {$this->table} WHERE id = :id";
      $req = Database::getBdd()->prepare($sql);
      return $req->execute([':id' => $model->getId()]);
   }

} 

