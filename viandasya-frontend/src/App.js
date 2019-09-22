import React from 'react';
//import logo from './logo.svg';
import './App.css';
import {Gmaps, Marker, InfoWindow, Circle} from 'react-gmaps';

const coords = {
  // UNQ - location
  // BROWSER=chrome npm start | choose browser
  lat: -34.706501,
  lng: -58.2807187
};

const params = {v: '3.exp', key: 'AIzaSyCk9lUgqQBF_EojnEsDkspDDp-ozqf1rnA'};
class App extends React.Component {

  onMapCreated(map) {
    map.setOptions({
      disableDefaultUI: true
    });
  }

  onDragEnd(e) {
    console.log('onDragEnd', e);
  }

  onCloseClick() {
    console.log('onCloseClick');
  }

  onClick(e) {
    console.log('onClick', e);
  }

  render() {
    return (
      <Gmaps
        width={'800px'}
        height={'600px'}
        lat={coords.lat}
        lng={coords.lng}
        zoom={12}
        loadingMessage={'Be happy'}
        params={params}
        onMapCreated={this.onMapCreated}>
        <Marker
          lat={coords.lat}
          lng={coords.lng}
          draggable={true}
          onDragEnd={this.onDragEnd} />
        <InfoWindow
          lat={coords.lat}
          lng={coords.lng}
          content={'Hello, Google :)'}
          onCloseClick={this.onCloseClick} />
        <Circle
          lat={coords.lat}
          lng={coords.lng}
          radius={500}
          onClick={this.onClick} />
      </Gmaps>
    );
  }

};

export default App;
