<html>
<head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Employee</title>
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" type="text/css">
</head>
<body style="padding: 25px;">
<div class="container">
        <form action="/employee" method="post"
              style="max-width: 320px; margin: 0 auto; font-size: larger;">
                <h3 class="form-signin-heading" align="center">Employee:</h3>
                <div class="form-group">
                        <input type="hidden" name="ID" title="" value="">
                </div>
                <div class="form-group">
                        <label for="inputName" class="sr-only">Name</label>
                        <input type="text" id="inputName" class="form-control" placeholder="" name=""
                               required autofocus style="z-index: 2;">
                </div>

                <div class="form-group">
                        <label for="inputDOB" class="sr-only">DOB</label>
                        <input type="text" id="inputDOB" class="form-control" placeholder="" name=""
                               required autofocus style="z-index: 2;">
                </div>

                <div class="form-group">
                        <label for="inputPhone" class="sr-only">Phone:</label>
                        <input type="text" id="inputPhone" class="form-control" placeholder="" name=""
                               required autofocus style="z-index: 2;">
                </div>

                <div class="form-group">
                        <label for="inputPosition" class="sr-only">Position</label>
                        <select id="inputPosition" class="form-control">
                                <option value="volvo">Manager</option>
                                <option value="saab">Cook</option>
                                <option value="mercedes">Waiter</option>
                        </select>
                </div>

                <div class="form-group">
                        <label for="inputSalary" class="sr-only">Salary</label>
                        <input type="text" id="inputSalary" class="form-control" placeholder="" name=""
                               required autofocus style="z-index: 2;">
                </div>

                <div class="form-group">
                        <button class="btn btn-primary btn-block" type="submit">Save</button>
                </div>


                <div class="form-group">
                        <div class="row">
                                <div class="col-md-6">
                                        <a class="hyperlink" href="/employees">See all</a>
                                </div>
                                <div class="col-md-6" align="right">
                                        <a class="hyperlink" href="/menu">Menu</a>
                                </div>
                        </div>
                </div>
        </form>
</div>
</body>
</html>
