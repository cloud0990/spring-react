import logo from './logo.svg';
import './App.css';

import { useState, useEffect } from "react";

function App() {

  const [message, setMessage] = useState("");

    useEffect(() => {

        fetch("/api/test")
            .then((res) => res.json())
            .then((json) => setMessage(json.SUCCESS_TEXT));
    }, []);

    console.log(message)

  return (
    <div className="App">
          TestPage
        <h1>{message}</h1>
      {/*<header className="App-header">
        <img src={logo} className="App-logo" alt="logo" />
        <p>
          Edit <code>src/App.js</code> and save to reload.
        </p>
        <a
            className="App-link"
            href="https://reactjs.org"
            target="_blank"
            rel="noopener noreferrer"
        >
          Learn React
        </a>
      </header>*/}
    </div>
  );
}

export default App;
