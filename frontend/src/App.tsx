import { Box, ChakraProvider, Grid, theme } from "@chakra-ui/react";
import { Route, Routes } from "react-router-dom";
import HeaderComponent from "./components/header/header";
import routes from "./config/navigation/routes";

export const App = () => (
  <ChakraProvider theme={theme}>
    <Box textAlign="center" fontSize="xl">
      <Grid minH="100vh" p={3}>
        <HeaderComponent />
        <Routes>
          {routes.map((route, index) => (
            <Route key={index} path={route.path} element={route.element} />
          ))}
        </Routes>
      </Grid>
    </Box>
  </ChakraProvider>
);
