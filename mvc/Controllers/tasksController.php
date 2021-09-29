<?php

namespace mvc\Controllers;

use mvc\Models\Task;
use mvc\Core\Controller;
use mvc\Models\TaskRepository;


class TasksController extends Controller
{
    function index()
    {
        // require(ROOT . 'Models/Task.php');

        $tasks = new Task();
        $taskRespository = new TaskRepository();

        $d['tasks'] = $taskRespository->getAll($tasks);
        $this->set($d);
        $this->render("index");
    }

    function create()
    {
        if (isset($_POST["title"]))
        {
            // require(ROOT . 'Models/Task.php');

            $task= new Task();
            $taskRespository = new TaskRepository();

            $task->setTitle($_POST['title']);
            $task->setDes($_POST['description']); 
                   
            if($taskRespository->add($task)){
                header("location: " . WEBROOT . "Tasks/index");
            }
            // if ($task->create($_POST["title"], $_POST["description"]))
            // {
            //     header("Location: " . WEBROOT . "tasks/index");
            // }
        }

        $this->render("create");
    }

    function edit($id)
    {
        // require(ROOT . 'Models/Task.php');
        $taskRespository = new TaskRepository();

    //    $d["task"] = $task->showTask($id);
        $d['tasks'] = $taskRespository->get($id);
        if (isset($_POST["title"]))
        {
            $task= new Task();
            
            $task->setId($id);
            $task->setTitle($_POST['title']);
            $task->setDes($_POST['description']);

            if($taskRespository->edit($task)){
                header("location:" . WEBROOT . "tasks/index");
                
            }
            // if ($task->edit($id, $_POST["title"], $_POST["description"]))
            // {
            //     header("Location: " . WEBROOT . "tasks/index");
            // }
        }
        $this->set($d);
        $this->render("edit");
    }

    function delete($id)
    {
        // require(ROOT . 'Models/Task.php');

        $task = new Task();
        $taskRespository = new TaskRepository();

        $task->setId($id);

        if($taskRespository->delete($task)){
            header("location:" . WEBROOT . "tasks/index");
        }  

        // if ($task->delete($id))
        // {
        //     header("Location: " . WEBROOT . "tasks/index");
        // }
    }
}
?>