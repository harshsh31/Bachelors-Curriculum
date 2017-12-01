<?php
$conn = mysqli_connect("localhost", "root", "");
if (!$conn) {
    die('Connect Error (' . mysqli_error());
}
$db_selected = mysqli_select_db($conn, 'ipl');
if (!$db_selected) {
    die ('Can\'t use db : ' . mysqli_error());
}
  


echo "Partition P0";
$res=mysqli_query($conn, "SELECT * FROM bowlers PARTITION (p0)");
$res1=mysqli_query($conn, "SELECT * FROM bowlers PARTITION (p1)");
    echo "<table class=simpletable border=1 align=center>";
    echo "<tr>
    <th align=left>ID</th>
    <th align=left>Name</th>
    <th align=left>Style</th>
    <th align=left>Wickets</th>
    </tr>";
while ($row = mysqli_fetch_assoc($res)) {
    $var1=$row['id'];
    $var2=$row['name']; 
    $var3=$row['wickets']; 
    $var4=$row['style']; 
    
    echo "<tr><td align=center>" . "$var1" . "</td>";
    echo "<td align=center>" . "$var2" . "</td>";
    echo "<td align=center>" . "$var3" . "</td>";
    echo "<td align=center>" . "$var4" . "</td>
    </tr>"; 

}
    echo "</table>";
    echo "Partition P1";
    echo "<table class=simpletable border=1 align=center>";
     echo "<tr>
    <th align=left>ID</th>
    <th align=left>Name</th>
    <th align=left>Style</th>
    <th align=left>Wickets</th>
    </tr>";
while ($row = mysqli_fetch_assoc($res1)) {
      $var1=$row['id'];
    $var2=$row['name']; 
    $var3=$row['wickets']; 
    $var4=$row['style']; 
    
    echo "<tr><td align=center>" . "$var1" . "</td>";
    echo "<td align=center>" . "$var2" . "</td>";
    echo "<td align=center>" . "$var3" . "</td>";
    echo "<td align=center>" . "$var4" . "</td>
    </tr>"; 

}
    echo "</table>";
?>
<!DOCTYPE html>
<html>
<head>
    <title>Hash Partitioning</title>
    <style type="text/css">
body {font-family:verdana;font-size:20px;color:#40434A}
.button {
    margin-top: 3%;
    background-color: #555555;
    border: none;
    color: white;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 20px;
    width:200px;height:50px;
}
h3 {font-family:verdana;font-size:24px;color:#181C26;}
table.simpletable {font-family:verdana;font-size:15px;color:#40434A;border-width:1px;border-color:#778AB8;border-collapse:collapse;}
table.simpletable th {border-width: 1px;padding: 10px;border-style: solid;border-color:#778AB8;background-color:#dedede;}
table.simpletable td {border-width: 1px;padding: 10px;border-style: solid;border-color: #778AB8;background-color: #ffffff;}
</style>
</head>
</html>
