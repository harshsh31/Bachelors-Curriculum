<?php
//echo "unable to access lock now\n\n";
$conn = mysqli_connect("localhost", "ipl", "");
if (!$conn) {
    die('Connect Error (' . mysqli_error());
}
$db_selected = mysqli_select_db($conn, 'ipl');
if (!$db_selected) {
    die ('Can\'t use db : ' . mysqli_error());
}
mysqli_query($conn, "UNLOCK TABLES");
echo "after sleep time Tables Unlocked Successfully and all locks released";
?>