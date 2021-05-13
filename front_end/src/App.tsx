import DataTable from "components/DataTable";
import Footer from "components/Footer";
import NavBar from "components/NavBar";

function App() {
  return (
    <>
    <div className="container">
      <NavBar />
      <h1 className="text-primary">Olá mundo!</h1>
      <DataTable />
    </div>
    <Footer />
    </>
  );
}

export default App;
