# Simple Azure IoT Edge Modules
This sample simply shows:
- How to write modules (sensor.js, printer.js, iothub_writer.js) in JavaScript.
- How to customize the IoT Edge runtime (gw.[local|cloud].config.json).
- How to initialize and start the IoT Edge application in JavaScript (app.js).

# Technical Details
## Callbacks
Each module (sensor/printer/iothub_writer) needs to implement callbacks for different events:
1. create - module is created
2. start - module starts
3. receive - receive message from broker
4. destroy - modules is destroyed
## Data pipeline
The configuration JSON file (gw.[local|cloud].config.json) to initialize each IoT Edge instance will 
need to define the data links for different module pairs.
## Connect to Azure IoT Hub
iothub_writer module shows you how to establish connection between IoT Edge application and Azure IoT Hub. Below are the steps to configure and run it:
1. Go to [Azure IoT Hub portal](https://azure.microsoft.com/en-us/services/iot-hub/) to create an 
IoT hub instance with your own Azure subscription account to connecte your IoT Edge application.
2. Update `gw.cloud.config.json` by replacing `<IoT Hub device connection string>` (in the 
`iothub_writer` module config JSON (*shown below*)) with your actual IoT Hub device connection
string
```
  {
    "name": "iothub_writer",
    "loader": {
      "name": "node",
      "entrypoint": {
        "main.path": "modules/iothub_writer.js"
      }
    },
    "args": {
      "connection_string": "<IoT Hub device connection string>"
    }
  }
```
3. `cd modules & npm install`
4. `cd .. & npm install`
5. `npm run cloud`
