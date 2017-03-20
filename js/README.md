# Simple Gateway Modules
This sample simply shows:
- How to write modules(sensor.js, printer.js) in Javascript.
- How to custmize the gateway runtime(gw.config.json).
- How to initialize and start the gateway application in Javascript(index.js).

# Technical Details
## Callbacks
Each module(sensor/printer) needs to implement callbacks for different events:
1. create - module is created.
2. start - module starts.
3. receive - receive message from broker.
4. destroy - modules is destroyed.
## Data pipeline
The configuration JSON file(gw.config.json) to initialize each gateway instance will need to define 
the data links for different module pair<sensor, printer>.