"use client";

import React, { useEffect, useRef, useState } from "react";
import CampoFormulario from "./CampoFormulario";

const NuevoProducto = () => {
  const dialogRef = useRef<HTMLDialogElement>(null);
  const [isOpen, setIsOpen] = React.useState(false);

  useEffect(() => {
    const dialog = dialogRef.current;
    if (dialog) {
      dialog.addEventListener("open", () => {
        setIsOpen(true);
      });
      dialog.addEventListener("close", () => {
        setIsOpen(false);
      });
    }
    
    return () => {
      if (dialog) {
        dialog.removeEventListener("open", () => setIsOpen(true));
        dialog.removeEventListener("close", () => setIsOpen(false));
      }
    };
  }, [dialogRef]);

  //Datos 
  const [codigo, setCodigo] = useState("")
  const [nombre, setNombre] = useState("")
  const [escala, setEscala] = useState("")
  const [vendedor, setVendedor] = useState("")
  const [descripcion, setDescripcion] = useState("")
  const [stock, setStock] = useState("")
  const [precioCompra, setPrecioCompra] = useState("")
  const [precioVenta, setPrecioVenta] = useState("")

  

  const saveNewProduct = (e: React.MouseEvent<HTMLButtonElement>) => {
    e.preventDefault();
    const newProduct = {
      productCode: codigo,
      productName: nombre,
      productScale: escala,
      productVendor: vendedor,
      productDescription: descripcion,
      quantityInStock: stock,
      buyPrice: precioCompra,
      msrp: precioVenta,
      productLine: { // This value is default
            productLine: "Trucks and Buses"
        }
    };
    console.log("Nuevo producto:", newProduct);
    // Aquí puedes hacer la llamada a la API para guardar el nuevo producto
    fetch(process.env.NEXT_PUBLIC_CLIENT_API_URL + "/products", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(newProduct),
    })
      .then((response) => {
        if (response.ok) {
          console.log("Producto guardado exitosamente");
          
          dialogRef.current?.close();

          setCodigo("");
          setNombre("");
          setEscala("");
          setVendedor("");
          setDescripcion("");
          setStock("");
          setPrecioCompra("");
          setPrecioVenta("");

        } else {
          console.error("Error al guardar el producto");
        }
      })
      .catch((error) => {
        console.error("Error en la solicitud:", error);
      });
  };

  return (
    <div>
      <button onClick={() => dialogRef.current?.showModal()} className="bg-blue-500 text-white p-2 rounded cursor-pointer">
        Nuevo Producto
      </button>

      <div className="">
        <dialog
          ref={dialogRef}
          className="rounded-lg p-4 absolute inset-0 m-auto bg-zinc-100"
        >
          <form method="dialog" className="absolute top-4 right-4">
            <button>
              <i className="fas fa-times"></i>
            </button>
          </form>
          <h2 className="text-lg font-bold uppercase text-blue-500">
            Agregar Producto
          </h2>
          <div className="p-3">
            <form className="flex flex-col">
              <div className="grid sm:grid-cols-1 md:grid-cols-2 gap-4">
                <CampoFormulario label="Codigo" nombre="Codigo" color="blue" value={codigo} setValue={setCodigo} />
                <CampoFormulario label="Nombre" nombre="Nombre" color="blue" value={nombre} setValue={setNombre} />
                <CampoFormulario label="Escala" nombre="Escala" color="blue" value={escala} setValue={setEscala} />
                <CampoFormulario label="Vendedor" nombre="Vendedor" color="blue" value={vendedor} setValue={setVendedor} />
                <CampoFormulario label="Descripción" nombre="Descripcion" color="blue" value={descripcion} setValue={setDescripcion} />
                <CampoFormulario label="Stock" nombre="Stock" color="blue" value={stock} setValue={setStock} />
                <CampoFormulario label="Precio de Compra" nombre="Precio Compra" color="blue" value={precioCompra} setValue={setPrecioCompra} />
                <CampoFormulario label="Precio de Venta" nombre="Precio Venta" color="blue" value={precioVenta} setValue={setPrecioVenta} />
              </div>
              <button className="bg-blue-500 text-white py-2 px-4 rounded-md w-auto mt-6 cursor-pointer" type="submit" onClick={(e) => saveNewProduct(e)}>Agregar</button>
            </form>
          </div>
        </dialog>
      </div>
    </div>
  );
};
export default NuevoProducto;
