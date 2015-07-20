<html>
<head>
<script>
	if(typeof(EventSource) !== "undefined") {
	    // Yes! Server-sent events support!
		var source = new EventSource("demo_sse.php");
		source.onmessage = function(event) {
			document.getElementById("result").innerHTML += event.data + "<br>";
		};
	} else {
	    // Sorry! No server-sent events support..
	    alert('Sorry there is no server-sent events support for this browser. Use modern browser');
	} 

</script>
</head>
<body>
	<h2>Hello World!</h2>
	<div id="result">
	</div>
</body>
</html>
