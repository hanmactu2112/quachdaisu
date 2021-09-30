<?php 
namespace mvc\Models;
use mvc\Models\StudentResourceModel;
class StudentRepository{
    private $studentResourceModel;

    public function __construct()
    {
        $this->studentResourceModel = new studentResourceModel();
    }

    public function add($model) 
    {
        return  $this->studentResourceModel->save($model);
    }

    public function edit($model)
    {
        return $this->studentResourceModel->save($model);
    }

    public function delete(\mvc\Models\Student $model)
    {
    
        return $this->studentResourceModel->delete($model);     
    }

    public function get(int $id)
    {
        return $this->studentResourceModel->get($id);
    }

    public function getAll($model)
    {
        return $this->studentResourceModel->getAll();
    }
}

?>

