# mongodb_springdata
mongodb 3.0&amp; spring_data_mongodb 1.7

this is mongodb 3.0 mongo-client replace mongodb
<pre>
&lt;mongo:mongo-client replace  id="mongo" replica-set="${mongo.hostport}"&gt;
	&lt;mongo:client-options 
	connections-per-host="${mongo.connectionsPerHost}"
	threads-allowed-to-block-for-connection-multiplier="${mongo.threadsAllowedToBlockForConnectionMultiplier}"
	connect-timeout="${mongo.connectTimeout}"
	max-wait-time="${mongo.maxWaitTime}"
	socket-keep-alive="${mongo.socketKeepAlive}" 
	socket-timeout="${mongo.socketTimeout}" &gt;
&lt;mongo:mongo-client &gt;
</pre>
