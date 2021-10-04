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
    <input name="sex" type="radio" class="form-control" id="sex" <?php if (isset($student->sex)) echo ($student->sex == 1 ? "checked" : '0') ?> value="1" />Nam
    <input name="sex" type="radio" class="form-control" id="sex" <?php if (isset($student->sex)) echo ($student->sex == 0 ? "checked" : '0') ?> value="0" />Nữ
    </div>
    <!-- <div class="form-group">
        <label for="sex">Sex</label>
        <input type="text" class="form-control" id="sex" placeholder="Enter sex" name="sex" value ="">
    </div> -->
    <button type="submit" class="btn btn-primary">Submit</button>
</form>