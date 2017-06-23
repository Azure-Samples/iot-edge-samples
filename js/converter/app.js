(function() {
  'use strict';

  const Gateway = require('azure-iot-gateway');
  let config_path = null;

  // node app.js [local | cloud ]
  if (process.argv.length < 3) {
    throw 'Calling pattern should be node app.js local.';
  }

  const option = process.argv[2];

  if (option === 'local') {
    config_path = './gw.local.config.json';
  } else {
    throw 'Invalid option to start app.js !';
  }

  const gw = new Gateway(config_path);
  gw.run();
})();
