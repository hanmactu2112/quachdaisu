<?php 
namespace mvc\Models;

use mvc\Models\Student;
use mvc\Core\ResourceModel;

class StudentResourceModel extends ResourceModel
{
    function __construct()
    {
        parent::_init('students', 'id', new Student);
    }
}   
?>