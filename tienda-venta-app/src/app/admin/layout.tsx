import type { Metadata } from "next";
import SideBar from "./components/SideBar";


export const metadata: Metadata = {
  title: "this admin",
  description: "Admin panel for managing the application",
};

export default function Layout({
  children,
}: Readonly<{
  children: React.ReactNode;
}>) {
  return (
    <div className="flex h-screen">
      <SideBar />
      <div className="max-h-[100vh] overflow-y-auto w-full">
        <div className="container mx-auto p-4">
          {children}
        </div>
      </div>
    </div>
  );
}
