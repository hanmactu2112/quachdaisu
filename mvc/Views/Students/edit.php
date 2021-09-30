<h1>Edit student</h1>
<form method='post' action='#'>
    <div class="form-group">
        <label for="name">Name</label>
        <?php foreach($students as $student) ?>
        <input type="text" class="form-control" id="name" placeholder="Enter name" name="name" value ="<?php if (isset($student->name)) echo $student->name;?>">
    </div>

    <div class="form-group">
        <label for="email">Email</label>
        <input type="email" class="form-control" id="email" placeholder="Enter email" name="email" value ="<?php if (isset($student->email)) echo $student->email;?>">
    </div>

    <div class="form-group">
        <label for="birthday">Birthday</label>
        <input type="text" class="form-control" id="birthday" placeholder="Enter birthday" name="birthday" value ="<?php if (isset($student->birthday)) echo $student->birthday;?>">
    </div>
    
    <div class="form-group">
        <label for="sex">Sex</label>
        <input type="text" class="form-control" id="sex" placeholder="Enter sex" name="sex" value ="<?php if (isset($student->sex)) echo $student->sex;?>">
    </div>
    <button type="submit" class="btn btn-primary">Submit</button>
</form>