import Link from "next/link";
import NuevoProducto from "./components/NuevoProducto";

const listAllProducts = async () => {
  const url = process.env.API_URL + "/products";
  const response = await fetch(url);
  if (!response.ok) {
    throw new Error("Failed to fetch products");
  }
  return response.json();
};
type Product = {
  productCode: string;
  productName: string;
  productLine: string;
  productScale: string;
  productVendor: string;
  productDescription: string;
  quantityInStock: number;
  buyPrice: number;
  msrp: number;
};

export default async function Home() {
  const products: Product[] = await listAllProducts();
  return (
    <div className="container mx-auto py-4">
      <h1 className="text-center text-5xl">Admin Page</h1>
      <div className="flex justify-center flex-col">
        <h2 className="text-2xl">Product List</h2>
        <div className="flex justify-between align-middle py-4">
          <div>
            <form>
              <label className="text-lg font-bold">
                Nombre
                <input className="border border-gray-300 px-2 py-1 rounded mx-2" type="text" name="nombre" id="nombre" placeholder="Nombre del producto"/>
              </label>
              <input className="bg-amber-500 rounded cursor-pointer p-2 font-bold" type="submit" value="Buscar" />
            </form>
          </div>
          <div>
            <NuevoProducto />
          </div>
        </div>
        <table className="min-w-full border-collapse border border-gray-200">
          <thead className="bg-slate-600">
            <tr>
              <th className="border border-gray-200 p-2">Name</th>
              <th className="border border-gray-200 p-2">Description</th>
              <th className="border border-gray-200 p-2">Vendor</th>
              <th className="border border-gray-200 p-2">Stock</th>
              <th className="border border-gray-200 p-2">Buy Price</th>
              <th className="border border-gray-200 p-2">MSRP</th>
              <th className="border border-gray-200 p-2">Opciones</th>
            </tr>
          </thead>
          <tbody className="bg-slate-800">
            {products.map((product) => (
              <tr key={product.productCode} className="border border-gray-200">
                <td className="border border-gray-200 p-2">
                  {product.productName}
                </td>
                <td className="border border-gray-200 p-2">
                  {product.productDescription.substring(0, 50)}...
                </td>
                <td className="border border-gray-200 p-2">
                  {product.productVendor}
                </td>
                <td className="border border-gray-200 p-2">
                  {product.quantityInStock}
                </td>
                <td className="border border-gray-200 p-2">
                  {product.buyPrice}
                </td>
                <td className="border border-gray-200 p-2">{product.msrp}</td>
                <td className="flex gap-2 p-2 justify-center">
                  <button className="bg-green-500 text-white p-2 rounded cursor-pointer">
                    Info
                  </button>
                  <button className="bg-blue-500 text-white p-2 rounded cursor-pointer">
                    Edit
                  </button>
                  <button className="bg-red-500 text-white p-2 rounded cursor-pointer">
                    Delete
                  </button>
                </td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
      
    </div>
  );
}
