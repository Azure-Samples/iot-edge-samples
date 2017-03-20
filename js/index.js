'use strict';

const Gateway = require('azure-iot-gateway');
let gw = new Gateway('./gw.config.json');
gw.run();
