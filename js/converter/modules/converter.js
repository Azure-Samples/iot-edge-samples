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
    // Initialize the messageCount in global object at first time.
    if (!global.messageCount) {
      global.messageCount = 0;
    }

    // Read the content and properties objects from message.
    let rawContent = JSON.parse(Buffer.from(message.content).toString('utf8'));
    let rawProperties = message.properties;

    // Generate new properties object.
    let newProperties = {
      source: rawProperties.source,
      macAddress: rawProperties.macAddress,
      temperatureAlert: rawContent.temperature > 30 ? 'true' : 'false'
    };

    // Generate new content object.
    let newContent = {
      deviceId: 'Intel NUC Gateway',
      messageId: ++global.messageCount,
      temperature: rawContent.temperature
    };

    // Publish the new message to broker.
    this.broker.publish(
      {
        properties: newProperties,
        content: new Uint8Array(Buffer.from(JSON.stringify(newContent), 'utf8'))
      }
    );
  },

  destroy: function () {
    console.log('converter.destroy');
  }
};
