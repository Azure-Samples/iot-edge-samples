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
    let properties = JSON.stringify(message.properties);
    let content = Buffer.from(message.content).toString('utf8');

    console.log(`printer.receive.properties - ${properties}`);
    console.log(`printer.receive.content - ${content}`);
  },

  destroy: function () {
    console.log('printer.destroy');
  }
};
