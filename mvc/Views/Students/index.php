<h1>Students</h1>

<div class="row col-md-12 centered">
    <table class="table table-striped custab">
        <thead>
        <a href="/mvc/students/create/" class="btn btn-primary btn-xs pull-right"><b>+</b> Add new student</a>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Email</th>
            <th>Birthday</th>
            <th>Sex</th>
            <th class="text-center">Action</th>
        </tr>
        </thead>
        <?php
        foreach ($students as $student)
        {
            echo '<tr>';
            echo "<td>" . $student->studentId . "</td>";
            echo "<td>" . $student->name . "</td>";
            echo "<td>" . $student->email . "</td>";
            echo "<td>" . $student->birthday . "</td>";
            echo "<td>" . $student->sex . "</td>";
            echo "<td class='text-center'><a class='btn btn-info btn-xs' href='/mvc/students/edit/" . $student->studentId . "' ><span class='glyphicon glyphicon-edit'></span> Edit</a> <a href='/mvc/students/delete/" . $student->studentId . "' class='btn btn-danger btn-xs'><span class='glyphicon glyphicon-remove'></span> Del</a></td>";
            echo "</tr>";
        }
        ?>
    </table>
</div>