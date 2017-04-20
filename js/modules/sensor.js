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
        name: 'input',
        content: [{
          'sensorId': 'device1',
          temp: this.rangeRand(10, 200),
          hmdt: this.rangeRand(0, 100)
        }, {
          'sensorId': 'device2',
          temp: this.rangeRand(10, 200),
          hmdt: this.rangeRand(0, 100)
        }, {
          'sensorId': 'device3',
          temp: this.rangeRand(10, 200),
          hmdt: this.rangeRand(0, 100)
        }]
      };

      this.broker.publish({
        properties: {
          source: 'sensor',
          name: 'data'
        },
        content: new Uint8Array(Buffer.from(JSON.stringify(data), 'utf8'))
      });
    }, 500);
  },

  rangeRand: function(min, max) {
    if (!Number.isInteger(min) || !Number.isInteger(max)) {
      console.error(`Please make sure ${min} and ${max} are integer.`);
      return;
    }

    return Math.floor(Math.random() * (max - min) + min);
  },

  receive: function(message) {
  },

  destroy: function() {
    console.log('sensor.destroy');
  }
};
