import type { Metadata } from "next";


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
    <>
      {children}
    </>
  );
}
