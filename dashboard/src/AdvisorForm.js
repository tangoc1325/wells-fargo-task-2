import React, { useState, useEffect } from "react";

function AdvisorForm({ onAdvisorCreated }) {
  // State for form fields
  const [firstName, setFirstName] = useState("");
  const [lastName, setLastName] = useState("");
  const [address, setAddress] = useState("");
  const [phone, setPhone] = useState("");
  const [email, setEmail] = useState("");
  const [error, setError] = useState("");

  // Handle form submission
  const handleSubmit = (e) => {
    e.preventDefault();
    setError("");

    // Build the request body
    const body = {
      firstName,
      lastName,
      address,
      phone,
      email,
    };

    // Send POST request to backend
    fetch("http://localhost:8080/advisors", {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(body),
    })
      .then((res) => {
        if (!res.ok) throw new Error("Failed to create advisor");
        return res.json();
      })
      .then((data) => {
        // Clear form
        setFirstName("");
        setLastName("");
        setAddress("");
        setPhone("");
        setEmail("");
        // Notify parent to refresh client list
        if (onAdvisorCreated) onAdvisorCreated();
      })
      .catch((err) => setError(err.message));
  };

  return (
    <form onSubmit={handleSubmit} style={{ marginBottom: "2em" }}>
      <h3>Add a New Advisor</h3>
      {error && <div style={{ color: "red" }}>{error}</div>}
      <div>
        <label>
          First Name:{" "}
          <input
            value={firstName}
            onChange={(e) => setFirstName(e.target.value)}
            required
          />
        </label>
      </div>
      <div>
        <label>
          Last Name:{" "}
          <input
            value={lastName}
            onChange={(e) => setLastName(e.target.value)}
            required
          />
        </label>
      </div>
      <div>
        <label>
          Address:{" "}
          <input
            value={address}
            onChange={(e) => setAddress(e.target.value)}
            required
          />
        </label>
      </div>
      <div>
        <label>
          Phone:{" "}
          <input
            value={phone}
            onChange={(e) => setPhone(e.target.value)}
            required
          />
        </label>
      </div>
      <div>
        <label>
          Email:{" "}
          <input
            value={email}
            onChange={(e) => setEmail(e.target.value)}
            required
          />
        </label>
      </div>
      <button type="submit">Add Advisor</button>
    </form>
  );
}

export default AdvisorForm;