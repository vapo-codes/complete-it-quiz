import { Box, Button, Heading, VStack } from "@chakra-ui/react";
import { useTranslation } from "react-i18next";

const Home = () => {
  const { t } = useTranslation();

  return (
    <VStack>
      <Heading
        fontWeight={600}
        fontSize={{ base: "2xl", sm: "4xl", md: "6xl" }}
      >
        CompleteIt
      </Heading>
      <Box display="flex" flexDirection="row" margin={5}>
        <Button colorScheme="yellow" marginRight={3}>{t("Let's play")}</Button>
        <Button variant="outline">
          {t("Login")}
        </Button>
      </Box>
    </VStack>
  );
};

export default Home;
