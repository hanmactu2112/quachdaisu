<?php

namespace mvc\Models;

use mvc\Core\Model;

class Student extends Model
{   
    protected $id;
    protected $name;
    protected $email;
    protected $birthday;
    protected $sex;

    public function setId($id)
    {
       $this->id=$id; 
    }

    public function setName($name)
    {
       $this->name = $name;
    }

    public function setEmail($email)
    {
       $this->email = $email;
    }

    public function setBirth($birthday)
    {
       $this->birthday = $birthday;
    }

    public function setSex($sex)
    {
       $this->sex = $sex;
    }

    public function getId()
    {
      return $this->id;
    }

    public function getName()
    {
     return  $this->name;
    }

    public function getEmail()
    {
     return  $this->email;
    }

    public function getSex()
    {
     return  $this->sex;
    }
}
?>