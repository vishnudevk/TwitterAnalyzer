<html>
<head>
<!--Import materialize.css-->
<link type="text/css" rel="stylesheet" href="css/font-awesome.css" media="screen,projection" />
<link type="text/css" rel="stylesheet" href="css/materialize.css" media="screen,projection" />
<link type="text/css" rel="stylesheet" href="css/style.css" media="screen,projection" />
<!-- Icon font -->
<link href="css/MaterialIcons.css" rel="stylesheet">

<!--Let browser know website is optimized for mobile-->
<meta name="viewport" content="width=device-width, initial-scale=1.0" />

<title>Home</title>
</head>
<body>

	<nav>
		<div class="nav-wrapper">
			<a href="#" class="brand-logo">Twitter analysis - Links</a>
		</div>
	</nav>

	<div class="row">
		<div class="col s12 m8 l6">
			<ul class="collection">
		        <li class="collection-item dismissable">
		        	<div>Realtime Sentiments
		        		<a href="pages/sentiments.html" class="secondary-content"><i class="material-icons">input</i></a>
		        	</div>
		        </li>
		        <li class="collection-item dismissable">
		        	<div>Realtime Sentiment graph
		        		<a href="pages/graph.html" class="secondary-content"><i class="material-icons">input</i></a>
		        	</div>
		        </li>
		        <li class="collection-item dismissable">
		        	<div>Compare tags
		        		<a href="pages/compare.html" class="secondary-content"><i class="material-icons">input</i></a>
		        	</div>
		        </li>
		    </ul>
			<!-- <div class="card">
				<div class="card-image"
					style="margin-top: 1.5em; margin-left: 1.5em; margin-right: 2em;">
					<span class="card-title">Realtime Sentiments</span>
				</div>
				<div class="card-content">
					<p>Page showing realtime twitter sentiments towards a filter</p>
				</div>
				<div class="card-action">
	        		<a href="pages/sentiments.html">Go</a>
	      		</div>
			</div> -->
		</div>
	</div>

	<!--Import jQuery before materialize.js-->
	<script type="text/javascript" src="js/jquery-2.1.1.js"></script>
	<script type="text/javascript" src="js/materialize.js"></script>
	<script type="text/javascript" src="js/angular.js"></script>
</body>
</html>
