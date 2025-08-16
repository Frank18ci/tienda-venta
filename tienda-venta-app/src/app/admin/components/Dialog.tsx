"use client";

import { useRef } from "react";

const Dialog = () => {
  const dialogRef = useRef<HTMLDialogElement>(null);

  return (
    <div>
      <button onClick={() => dialogRef.current?.showModal()}>
        Abrir diálogo
      </button>

      <div className="">
        <dialog ref={dialogRef} className="rounded-lg p-4 absolute inset-0 m-auto">
          <form method="dialog" className="absolute top-4 right-4">
            <button>
                <i className="fas fa-times"></i>
            </button>
          </form>
          <h2 className="text-lg font-bold">Agregar Producto</h2>
          <form className="flex flex-col">
            <label>
              Nombre:
              <input type="text" name="nombre" />
            </label>
            <label>
              Precio:
              <input type="number" name="precio" />
            </label>
            <button type="submit">Agregar</button>
          </form>
          
      </dialog>
      </div>
    </div>
  );
};
export default Dialog;
