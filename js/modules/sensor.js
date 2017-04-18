'use strict';

module.exports = {
  broker: null,
  configuration: null,

  create: function (broker, configuration) {
    this.broker = broker;
    this.configuration = configuration;

    return true;
  },

  start: function () {
    setInterval(() => {
      let data = {
        temp: Math.random() * 50,
        hmdt: Math.random() * 80
      };

      this.broker.publish({
        properties: {
          'source': 'sensor'
        },
        content: new Uint8Array(Buffer.from(JSON.stringify(data), 'utf8'))
      });
    }, 500);
  },

  receive: function(message) {
  },

  destroy: function() {
    console.log('sensor.destroy');
  }
};
