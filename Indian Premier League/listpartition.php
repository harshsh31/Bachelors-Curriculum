<?php
$conn = mysqli_connect("localhost", "root", "","ipl");
if (!$conn) {
    die('Connect Error (' . mysqli_error());
}
/*$db_selected = mysqli_select_db($conn, 'ipl');
if (!$db_selected) {
    die ('Can\'t use db : ' . mysqli_error());
}
*/  

echo "Partition YOUNG"; 
$res=mysqli_query($conn, "SELECT * FROM Player PARTITION (YOUNG)");
	echo "<table class=simpletable border=1 align=center>";
	echo "<tr><th align=left>Name</th>
    <th align=left>Age</th>
    <th align=left>Nationality</th></tr>";
while ($row = mysqli_fetch_assoc($res)) {
	$var1=$row['Name'];
    $var2=$row['Age'];
    $var3=$row['Nationality'];
    echo "
    <tr>
        <td align=center>" . "$var1" . "</td>
        <td align=center>" . "$var2" . "</td>
        <td align=center>" . "$var3" . "</td>
    </tr>";
   
}
	echo "</table>";
?>
<!DOCTYPE html>
<html>
<head>
	<title>List Partitioning</title>
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
