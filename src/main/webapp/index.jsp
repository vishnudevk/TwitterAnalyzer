<html>
<head>
<!--Import materialize.css-->
<link type="text/css" rel="stylesheet" href="css/materialize.css" media="screen,projection" />
<link type="text/css" rel="stylesheet" href="css/angular-chart.css" media="screen,projection" />
<link type="text/css" rel="stylesheet" href="css/style.css" media="screen,projection" />
<!-- Icon font -->
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">


<!--Let browser know website is optimized for mobile-->
<meta name="viewport" content="width=device-width, initial-scale=1.0" />


</head>
<body  ng-app="myApp" ng-controller="tweetsCtrlr">

	<nav>
		<div class="nav-wrapper">
			<a href="#" class="brand-logo">Twitter analysis</a>
			<ul id="nav-mobile" class="right hide-on-med-and-down">
				<li><a href="#">Number of tweets analyzed for the session: {{tweetSize}}</a></li>
				<li><a href="#">Sentiment for the session : 0</a></li>
			</ul>
		</div>
	</nav>

    <div class="row card-panel  materialize-red lighten-2 shades-text text-white hide-on-large-only" style="font-size:1.2em;">
		<div class="col m6 s12"> Number of tweets analyzed : {{tweetSize}} </div>
		<div class="col m6 s12 right">Sentiment for the session : 0</div>
    </div>
            
	<div>
		<ul  class="collection">
			<!-- {{ tweet.id + ', ' + tweet.text }} {{tweet.id}} -->
			<li ng-repeat="tweet in tweets" class="collection-item avatar animate-repeat">
				<div class="sentimentMarker {{tweet.colorClass}}"></div>
				<img src="{{tweet.user.profileImageUrl}}" alt="" class="circle"> 
				<span class="title">{{tweet.user.name}}</span>
				<p>
					{{tweet.text}}
				</p> 
				<!-- <a href="#!" class="secondary-content">
				<i class="material-icons">{{tweet.sentiment}}</i></a> -->
			</li>
		</ul>
	</div>
	
	
<!--Import jQuery before materialize.js-->
<script type="text/javascript" src="js/jquery-2.1.1.js"></script>
<script type="text/javascript" src="js/materialize.js"></script>
<script type="text/javascript" src="js/angular.js"></script>
<script type="text/javascript" src="js/Chart.js"></script>
<script type="text/javascript" src="js/angular-chart.js"></script>
 
<script>
	
	//angular codes
	var app = angular.module('myApp', []); 
	app.controller('tweetsCtrlr', function($scope) {
	    $scope.tweetSize= 0;
	    $scope.tweetSenti;
	    $scope.tweets= [];
	    
	    if (typeof (EventSource) !== "undefined") {
			// Yes! Server-sent events support!
			var source = new EventSource("tweetList.get");
			source.onmessage = function(event) {
			//	document.getElementById("result").innerHTML += event.data + "<br>";
				var tweet = JSON.parse(event.data);
				//logic for giving color based on the tweet sentiment
				var colorClass = "yellowIndicator";
				if(tweet.sentiment>.1){
					colorClass = "greenIndicator"
				}else if(tweet.sentiment<-.1){
					colorClass = "redIndicator"
				}
				tweet.colorClass = colorClass;

				$scope.tweets.unshift(tweet);
				$scope.tweetSize=$scope.tweets.length;
				$scope.$apply();
			};
		} else {
			// Sorry! No server-sent events support..
			alert('Sorry there is no server-sent events support for this browser. Use modern browser');
		}
	}); 
	
</script>
	
</body>
</html>
