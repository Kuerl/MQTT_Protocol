import React, {useEffect} from 'react';
import { View, Text, Button } from 'react-native';

import {mqtt} from './src/subClient';
 
export default () => {

  useEffect(() => {
    const client = mqtt.client;
    client.getSubscribe('test');
    client.getMessage();
  }, [])

  return (
    <View>
      <Text>react_native_mqtt</Text>
      <Button
        title="Press me" 
        // onPress={() => {
        //   client.onSubscribe.getSubscribe('test');
        // }}
      />
    </View>
  )
}