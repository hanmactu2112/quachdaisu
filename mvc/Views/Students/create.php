<h1>Create student</h1>
<form method='post' action='#'>
    <div class="form-group">
        <label for="name">Name</label>
        <input type="text" class="form-control" id="name" placeholder="Enter name" name="name">
    </div>

    <div class="form-group">
        <label for="email">Email</label>
        <input type="text" class="form-control" id="email" placeholder="Enter email" name="email">
    </div>

    <div class="form-group">
        <label for="birthday">Birthday</label>
        <input type="text" class="form-control" id="birthday" placeholder="Enter birthday" name="birthday">
    </div>
    <div class="form-group">
    <input name="sex" type="radio" class="form-control" id="sex" value="1" />Nam
    <input name="sex" type="radio" class="form-control" id="sex" value="0" />Nữ
    </div>
    <!-- <div class="form-group">
        <label for="sex">Sex</label>
        <input type="text" class="form-control" id="sex" placeholder="Enter sex" name="sex">
    </div> -->
    <button type="submit" class="btn btn-primary">Submit</button>
</form>