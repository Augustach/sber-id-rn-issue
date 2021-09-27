/**
 * Sample React Native App
 * https://github.com/facebook/react-native
 *
 * @format
 * @flow strict-local
 */

import React from 'react';
import {View} from 'react-native';
import {SberIDButton} from './SberIDButton';

const App = () => {
  return (
    <View style={{backgroundColor: 'white', flex: 1, padding: 16}}>
      <SberIDButton style={{width: '100%', height: 40}} />
    </View>
  );
};

export default App;
