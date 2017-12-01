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
if (isset($_POST['team_id']))    
{
        $Team_id = $_POST['team_id'];
       // $id = (int)$id;
        //$id=mysql_real_escape_string($id);
        $team_name = $_POST['teamname'];
        //$name=mysql_real_escape_string($name);
        //s$wid=mysql_real_escape_string($wid);
        $Budget = $_POST['Budget'];
        $Points = $_POST['points'];
        $Players = $_POST['players'];
    
    //$qry="LOCK TABLE employee Write";
    //$result=mysql_query($qry,$con);
    //if($result){echo "locked";}
    //$result=mysql_query($qry,$con);
    //$qry="INSERT INTO work (workid,work_name) values ('$id','$name')";
    $qry="INSERT INTO `team` (`Team_id`, `Name`, `Budget`, `Points`, `Players`) VALUES ($Team_id,'$team_name',$Budget,$Points,$Players)";
    //echo $qry;
    $result=$conn->query($qry);
    header('location: index.html');
}
else{   
    echo "Hello";
}
?>