/**
 * Sample React Native App
 * https://github.com/facebook/react-native
 *
 * @format
 * @flow strict-local
 */

import React from 'react';
import {
  SafeAreaView,
  StyleSheet,
  ScrollView,
  View,
  Text,
  StatusBar,
} from 'react-native';

import {
  Header,
  LearnMoreLinks,
  Colors,
  DebugInstructions,
  ReloadInstructions,
} from 'react-native/Libraries/NewAppScreen';

const App: () => React$Node = () => {
  return (
    <View style={styles.container}>
      <View style={styles.mainContainer}>
        <View style={styles.recieveContainer}>
          <Text style={styles.recieveContainerText}>Recieve MQTT Text!</Text>
        </View>
        <View style={styles.featureContainer}>
          <Text style={styles.featureContainerText}>
            Testing for publish messages MQTT!
          </Text>
        </View>
      </View>
    </View>
  );
};

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: '#0e1621',
  },
  mainContainer: {
    flex: 1,
    margin: 10,
  },
  recieveContainer: {
    flex: 7,
    backgroundColor: '#2b5278',
    marginBottom: 10,
    borderRadius: 10,
    padding: 10,
  },
  recieveContainerText: {
    color: 'white',
  },
  featureContainer: {
    flex: 1,
    backgroundColor: '#2b5278',
    borderRadius: 10,
    padding: 10,
  },
  featureContainerText: {
    color: 'white',
    fontWeight: 'bold',
  },
});

export default App;
