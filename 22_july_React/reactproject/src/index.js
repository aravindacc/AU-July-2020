import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import * as serviceWorker from './serviceWorker';
import MyContext from './component/MyContext';



ReactDOM.render(
  <React.StrictMode>
    <MyContext/>
  </React.StrictMode>,
  document.getElementById('root')
);


serviceWorker.register();
