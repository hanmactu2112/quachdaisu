<?php 
namespace mvc\Models;
use mvc\Models\TaskResourceModel;
class TaskRepository{
    private $taskResourceModel;

    public function __construct()
    {
        $this->taskResourceModel = new TaskResourceModel();
    }

    public function add($model) 
    {
        return  $this->taskResourceModel->save($model);
    }

    public function edit($model)
    {
        return $this->taskResourceModel->save($model);
    }

    public function delete(\mvc\Models\Task $model)
    {
    
        return $this->taskResourceModel->delete($model);     
    }

    public function get(int $id)
    {
        return $this->taskResourceModel->get($id);
    }

    public function getAll($model)
    {
        return $this->taskResourceModel->getAll();
    }
}

?>

