import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'
import toast, { Toaster } from 'react-hot-toast'
import { useAuth } from './config/authContext'

function App() {
  const {isAuthenticated} = useAuth()
  console.log(isAuthenticated);
  return (
    <>
      <Toaster/>

      {
        isAuthenticated ? <div>
          <h1>Welcome to OAuth2 client</h1>
          <p>You are loged in</p>
          <button>Logout</button>
        </div> : <div>
          <h1>Login Required</h1>
          <button>Login</button>
        </div>
      }
    </>
  )
}

export default App
