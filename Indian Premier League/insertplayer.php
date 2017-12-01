<?php
    //ini_set('mysql.connection_timeout', 300);
    //ini_set('default_socket_timmeout', 300);
    //$conn = new mysqli("localhost", "root", "", "railways");
    //if (!empty($_POST['emp_id'])){
                            $servername = "localhost";
							$username = "root";
							$password = "";
							$dbname = "ipl";
							$data1 = "";
							if (isset($_REQUEST['variable1'])&& !empty($_REQUEST['variable1'])) 
							{ 
							$data1 = $_REQUEST['variable1']; 
							//echo "test";
							}
							// Create connection
							$conn = new mysqli($servername, $username, $password, $dbname);
							// Check connection
							if ($conn->connect_error) {
							     die("Connection failed: " . $conn->connect_error);
							} 
							$int = (int)$data1;
if (isset($_POST['player_id']))    
{
        $id = $_POST['player_id'];
       // $id = (int)$id;
        //$id=mysql_real_escape_string($id);
        $name = $_POST['playerame'];
        //$name=mysql_real_escape_string($name);
        $DOB = $_POST['DOB'];

        $age = $_POST['age'];
       // $age = (int)$age;
        //$age=mysql_real_escape_string($age);
        $Nationality = $_POST['Nationality'];
        //$gender=mysql_real_escape_str)ing($gender);
        $Batpref = $_POST['Batpref'];
       // $salary = (int)$salary;
        //$salary=mysql_real_escape_string($salary);
        $Bowlpref = $_POST['Bowlpref'];
       // $wid = (int)$wid;
        //s$wid=mysql_real_escape_string($wid);
        
    
    //$qry="LOCK TABLE employee Write";
    //$result=mysql_query($qry,$con);
    //if($result){echo "locked";}
    //$result=mysql_query($qry,$con);
    //$qry="INSERT INTO employee (emp_id,emp_name,emp_age,emp_gender,emp_salary,wid) values ('$id','$name',$age,'$gender','$salary','$wid')";
    $qry="INSERT INTO `player`(`Player_id`, `Name`, `DOB`, `Age`, `Nationality`, `Batpref`, `Bowlpref`) VALUES ($id,'$name','$DOB',$age,'$Nationality','$Batpref','$Bowlpref')";
    $result=$conn->query($qry);
    header('location: index.html');
}
else{   
    echo "error while inserting data";
}
?>