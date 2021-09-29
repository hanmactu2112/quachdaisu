<?php 
namespace mvc\Models;

use mvc\Models\Task;
use mvc\Core\ResourceModel;

class TaskResourceModel extends ResourceModel
{
    function __construct()
    {
        parent::_init('tasks', 'id', new Task);
    }
}   
?>