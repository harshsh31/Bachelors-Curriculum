<?php
$conn = mysqli_connect("localhost", "root", "");
if (!$conn) {
    die('Connect Error (' . mysqli_error());
}
$db_selected = mysqli_select_db($conn, 'ipl');
if (!$db_selected) {
    die ('Can\'t use db : ' . mysqli_error());
}
mysqli_query($conn, "LOCK TABLES player WRITE");
echo "unable to access lock now\n\n";

sleep(5);
header("Location: unlock.php");
?>