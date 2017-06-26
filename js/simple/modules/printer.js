'use strict';

module.exports = {
  broker: null,
  configuration: null,

  create: function (broker, configuration) {
    this.broker = broker;
    this.configuration = configuration;

    return true;
  },

  receive: function (message) {
    let data = Buffer.from(message.content).toString('utf8');

    console.log(`printer.receive - ${data}`);
  },

  destroy: function () {
    console.log('printer.destroy');
  }
};
