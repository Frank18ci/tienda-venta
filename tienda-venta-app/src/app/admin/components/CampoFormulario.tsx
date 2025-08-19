
const CampoFormulario = ({ label, nombre, color, value, setValue }: { label: string, nombre: string, color: string, value: string, setValue: React.Dispatch<React.SetStateAction<string>> }) => {
  return (
    <div className="relative flex items-center">
      <input
        id={label}
        name={label}
        type="text"
        placeholder=" "
        required
        className={
          "peer py-3 bg-zinc-100 text-gray-800 rounded-md p-2 w-full outline-none border border-gray-300 focus:border-" +
          color +
          "-400 transition-colors"
        }
        value={value}
        onChange={(e) => setValue(e.target.value)}
      />
      <label
        htmlFor={label}
        className={
          "absolute left-2 text-gray-600 transition-all duration-200 bg-zinc-100 px-1 select-none " +
          "peer-placeholder-shown:top-3 peer-placeholder-shown:text-base peer-placeholder-shown:text-gray-600 " +
          "peer-focus:-top-2 peer-focus:left-3 peer-focus:text-sm peer-focus:text-" + color + "-400 " +
          "peer-not-placeholder-shown:-top-2 peer-not-placeholder-shown:left-3 peer-not-placeholder-shown:text-sm"
        }
      >
        {nombre}
      </label>
    </div>
  );
};

export default CampoFormulario;
