import Link from "next/link";

const SideBar = () => {
    return (
        <div className="w-64 flex flex-col  align-middle bg-slate-900 text-white px-12 py-4">
            <h1 className="text-5xl font-bold my-4">
                Admin
            </h1>
            <ul className="text-lg space-y-5 text-center">
                <li>
                    <Link href="/admin/productos" className="text-slate-300 hover:text-slate-200">
                    <i className="fas fa-box"></i>
                    Productos</Link>
                </li>
                <li>
                    <Link href="/admin/usuarios" className="text-slate-300 hover:text-slate-200">
                    <i className="fas fa-users"></i>
                    Usuarios</Link>
                </li>
                <li>
                    <Link href="/admin/pedidos" className="text-slate-300 hover:text-slate-200">
                    <i className="fas fa-shopping-cart"></i>
                    Pedidos</Link>
                </li>
                <li>
                    <Link href="/admin/reportes" className="text-slate-300 hover:text-slate-200">
                    <i className="fas fa-chart-line"></i>
                    Reportes</Link>
                </li>
                <li>
                    <Link href="/admin/configuracion" className="text-slate-300 hover:text-slate-200">
                    <i className="fas fa-cog"></i>
                    Configuración</Link>
                </li>
            </ul>
        </div>
    )
}
export default SideBar;