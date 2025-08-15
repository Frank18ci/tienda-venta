import Link from "next/link";

export default function Home() {
  return (
    <div className="flex justify-center items-center min-h-screen">
      <div className="flex flex-col">
        <h1 className="text-4xl font-bold">Welcome to the Home Page</h1>
        <div className="flex justify-center gap-5">
          <Link href="/admin" className="mt-4 text-blue-500 hover:underline">Go to Admin Page</Link>
          <Link href="/about" className="mt-4 text-blue-500 hover:underline">Go to About Page</Link>
        </div>
      </div>
    </div>
  );
}
