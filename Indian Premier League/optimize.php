		<?php
$conn = mysqli_connect("localhost", "root", "");
if (!$conn) {
    die('Connect Error (' . mysqli_error());
}
$db_selected = mysqli_select_db($conn, 'ipl');
if (!$db_selected) {
    die ('Can\'t use db : ' . mysqli_error());
}
$qry="SELECT * FROM player";
echo "<div class='loginDiv'>";
			echo "<fieldset>";
			echo "<h1>Results:</h1><br>";
			echo "Before Optimization";

			echo "<br>";
			$msc = microtime(true);
			mysqli_query($conn,$qry);
			$msc = microtime(true) - $msc;
			echo $msc . ' seconds '; 
			echo "<br>";
			echo ($msc * 1000) . ' milliseconds'; 
			echo "<br><br></fieldset>";
			echo "</div>";


			$qry="optimize table player";
			$qry="SELECT * FROM player";

			echo "<br>";
			echo "<br>";

			echo "<div class='loginDiv'>";
			echo "<fieldset>";
			echo "<h1>Results:</h1><br>";
			echo "After Optimization";
			echo "<br>";

			$msc = microtime(true);
			mysqli_query($conn,$qry);
			$msc = microtime(true) - $msc;
			echo $msc . ' seconds '; // in seconds
			echo "<br>";
			echo ($msc * 1000) . ' milliseconds'; // in millseconds
			echo "<br><br></fieldset>";
			echo "</div>"; 		

		?>
<!DOCTYPE html>
<html>
<head>
	<title>OPTIMIZATION</title>
	<style type="text/css">
	body {font-family:verdana;font-size:20px;color:#40434A}
	</style>
</head>
<body>

</body>
</html>