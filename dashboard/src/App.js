import React, { useEffect, useState } from "react";
import ClientForm from "./ClientForm";
import AdvisorForm from "./AdvisorForm";
import "./App.css";

function App() {
  const [advisors, setAdvisors] = useState([]);
  const [clients, setClients] = useState([]);
  const [editingClientId, setEditingClientId] = useState(null);
  const [editClientData, setEditClientData] = useState({});

  // Fetch advisors
  useEffect(() => {
    fetch("http://localhost:8080/advisors")
      .then((res) => res.json())
      .then(setAdvisors);
  }, []);

  // Fetch clients
  const fetchClients = () => {
    fetch("http://localhost:8080/clients")
      .then((res) => res.json())
      .then(setClients);
  };

  useEffect(() => {
    fetchClients();
  }, []);

  const fetchAdvisors = () => {
    fetch("http://localhost:8080/advisors")
      .then((res) => res.json())
      .then(setAdvisors);
  };

  return (
    <div>
      <h1>Advisors and Their Clients</h1>
      <AdvisorForm onAdvisorCreated={fetchAdvisors} />
      <ClientForm advisors={advisors} onClientCreated={fetchClients} />
      {advisors.map((advisor) => (
        <div key={advisor.advisorId} style={{ marginBottom: "2em" }}>
          <h2>
            {advisor.firstName} {advisor.lastName} (ID: {advisor.advisorId})
            <button
              style={{ marginLeft: "1em" }}
              onClick={() => {
                fetch(`http://localhost:8080/advisors/${advisor.advisorId}`, {
                  method: "DELETE",
                }).then(() => {
                  fetchAdvisors();
                  fetchClients();
                });
              }}
            >
              Delete
            </button>
          </h2>
          <ul>
            {clients
              .filter(
                (client) =>
                  client.advisorId && client.advisorId.advisorId === advisor.advisorId
              )
              .map((client) => (
                <li key={client.clientId}>
                  {editingClientId === client.clientId ? (
                    <form
                      onSubmit={e => {
                        e.preventDefault();
                        fetch(`http://localhost:8080/clients/${client.clientId}`, {
                          method: "PUT",
                          headers: { "Content-Type": "application/json" },
                          body: JSON.stringify(editClientData),
                        }).then(() => {
                          setEditingClientId(null);
                          fetchClients();
                        });
                      }}
                    >
                      {/* Edit client details */}
                      <input
                        value={editClientData.firstName || ""}
                        onChange={e =>
                          setEditClientData({ ...editClientData, firstName: e.target.value })
                        }
                        required
                      />
                      <input
                        value={editClientData.lastName || ""}
                        onChange={e =>
                          setEditClientData({ ...editClientData, lastName: e.target.value })
                        }
                        required
                      />
                      <input
                        value={editClientData.address || ""}
                        onChange={e =>
                          setEditClientData({ ...editClientData, address: e.target.value })
                        }
                        required
                      />
                      <input
                        value={editClientData.phone || ""}
                        onChange={e =>
                          setEditClientData({ ...editClientData, phone: e.target.value })
                        }
                        required
                      />
                      <input
                        value={editClientData.email || ""}
                        onChange={e =>
                          setEditClientData({ ...editClientData, email: e.target.value })
                        }
                        required
                      />
                      {/* change advisorId */}
                      {<select
                        value={editClientData.advisorId.advisorId}
                        onChange={e =>
                          setEditClientData({
                            ...editClientData,
                            advisorId: { advisorId: Number(e.target.value) },
                          })
                        }
                      >
                        {advisors.map((advisor) => (
                          <option key={advisor.advisorId} value={advisor.advisorId}>
                            {advisor.firstName} {advisor.lastName}
                          </option>
                        ))}
                      </select>}
                      <button type="submit">Save</button>
                      <button type="button" onClick={() => setEditingClientId(null)}>
                        Cancel
                      </button>
                    </form>
                  ) : (
                    <>
                      {client.firstName} {client.lastName} (ID: {client.clientId})
                      <button
                        style={{ marginLeft: "1em" }}
                        onClick={() => {
                          setEditingClientId(client.clientId);
                          setEditClientData(client);
                        }}
                      >
                        Edit
                      </button>
                      <button
                        style={{ marginLeft: "1em" }}
                        onClick={() => {
                          fetch(`http://localhost:8080/clients/${client.clientId}`, {
                            method: "DELETE",
                          }).then(() => fetchClients());
                        }}
                      >
                        Delete
                      </button>
                    </>
                  )}
                </li>
              ))}
          </ul>
        </div>
      ))}
    </div>
  );
}

export default App;