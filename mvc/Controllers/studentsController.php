<?php

namespace mvc\Controllers;

use mvc\Models\Student;
use mvc\Core\Controller;
use mvc\Models\StudentRepository;


class StudentsController extends Controller
{
    function index()
    {
        $students = new Student();
        $studentRespository = new StudentRepository();
        $d['students'] = $studentRespository->getAll($students);
        $this->set($d);
        $this->render("index");
    }

    function create()
    {
        if (isset($_POST["name"]))
        {
            $students = new Student();
            $studentRespository = new StudentRepository();

            $students->setName($_POST['name']);
            $students->setEmail($_POST['email']);
            $students->setBirth($_POST['birthday']);
            $students->setSex($_POST['sex']); 
            if($studentRespository->add($students)){
                header("location: " . WEBROOT . "students/index");
            }
        }

        $this->render("create");
    }

    function edit($id)
    {
        $studentRespository = new StudentRepository();

        $d['students'] = $studentRespository->get($id);
        if (isset($_POST["name"]))
        {
            $student = new Student();
            
            $student->setId($id);
            $student->setName($_POST['name']);
            $student->setEmail($_POST['email']);
            $student->setBirth($_POST['birthday']);
            $student->setSex($_POST['sex']); 

            if($studentRespository->edit($student)){
                header("location:" . WEBROOT . "students/index");
            }
        }
        $this->set($d);
        $this->render("edit");
    }

    function delete($id)
    {
        $student = new Student();
        $studentRespository = new StudentRepository();

        $student->setId($id);

        if($studentRespository->delete($student)){
            header("location:" . WEBROOT . "students/index");
        }  
    }
}
?>