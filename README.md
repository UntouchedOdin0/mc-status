# MCStatus
This is an incredibly simple terminal-based Minecraft server status checker. I don't anticipate really updating this, and it works off the API provided [here](https://api.mcsrvstat.us/).  

I made it simply because I wanted one, and couldn't find one that was quite this simple. Feel free to use this for whatever you want and/or PR for more features :)

There isn't good error checking whatsoever, because I personally don't need it. Follow the guide below and you'll be good.

### Checking a server's status
```shell
> java -jar {jarFileName}.jar server.address.goes.here
```

### Example execution & response
```shell
> java -jar ./mcstatus.jar hypixel.net
Server Status: true (68032/200000)
```