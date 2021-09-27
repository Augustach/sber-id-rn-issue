import React from 'react';
import {requireNativeComponent} from 'react-native';

const NativeSberIDButton = requireNativeComponent('SberIDButton');

export const SberIDButton = props => <NativeSberIDButton {...props} />;
